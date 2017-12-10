package com.link.common.kit;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.jfinal.kit.StrKit;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;

/**
 * 二维码工具
 * @author linkzz
 * @create 2017-12-01 15:40
 */
public class PhotoQrCodeKit extends Render {
    private MatrixToImageConfig defaultConfig = new MatrixToImageConfig();

    private String content;
    private int width;
    private int height;
    private ErrorCorrectionLevel errorCorrectionLevel;
    private String url;

    /**
     * 构造方法，纠错参数默认使用的是'L'最低级别纠错参数
     * @param height 二维码高度
     * @param width 二维码宽度
     * @param content 二维码携带的内容
     * @author linkzz
     * @create 2017-12-01 16:28
     */
    public PhotoQrCodeKit(String content, int width, int height) {
        init(content, width, height, ErrorCorrectionLevel.H);
    }

    /**
     * 黑白图标
     * @param content 二维码内容
     * @param width 二维码宽度
     * @param height 二维码高度
     * @param logoUrl 网络图标地址
     * @author linkzz
     * @create 2017-12-01 16:31
     */
    public PhotoQrCodeKit(String content, int width, int height, String logoUrl) {
        init(content, width, height, ErrorCorrectionLevel.H);
        url = logoUrl;
    }

    /**
     * 指定二维码颜色，白色背景
     * @param logoUrl 网络图标地址
     * @param onColor 二维码颜色
     * @author linkzz
     * @create 2017-12-01 16:35
     */
    public PhotoQrCodeKit(String content, int width, int height, String logoUrl, int onColor) {
        init(content, width, height, ErrorCorrectionLevel.H);
        url = logoUrl;
        onColor = (((onColor >> 24) & 0xff) > 0) ? onColor : onColor | 0xff000000;
        defaultConfig = new MatrixToImageConfig(onColor, 0xffffff);
    }

    /**
     * 指定前景 背景颜色
     * @param onColor 指定背景颜色
     * @param offColor 指定前景颜色
     * @author linkzz
     * @create 2017-12-01 16:38
     */
    public PhotoQrCodeKit(String content, int width, int height, String logoUrl, int onColor, int offColor) {
        init(content, width, height, ErrorCorrectionLevel.H);
        url = logoUrl;
        defaultConfig = new MatrixToImageConfig(onColor, offColor);
    }

    private void init(String content, int width, int height, ErrorCorrectionLevel errorCorrectionLevel) {
        if (StrKit.isBlank(content)) {
            throw new IllegalArgumentException("content 不能为空");
        }
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("width 与 height 不能小于 0");
        }
        this.content = content;
        this.width = width;
        this.height = height;
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

    @Override
    public void render() {
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");

        EnumMap<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 去掉白色边框，极度重要，否则二维码周围的白边会很宽
        hints.put(EncodeHintType.MARGIN, 0);
        if (errorCorrectionLevel != null) {
            hints.put(EncodeHintType.ERROR_CORRECTION, errorCorrectionLevel);
        }
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            // 经测试 200 X 200 大小的二维码使用 "png" 格式只有 412B，而 "jpg" 却达到 15KB
            // String path =
            overlapImage(bitMatrix, "png", response.getOutputStream(), url);
        } catch (Exception e) {
            throw new RenderException(e);
        }
    }

    private void overlapImage(BitMatrix matrix, String format, ServletOutputStream outputStream, String logoPath) throws IOException {
        BufferedImage image = MatrixToImageWriter.toBufferedImage(matrix, defaultConfig);
        if (logoPath != null) {
            BufferedImage logo = ImageIO.read(new URL(logoPath).openStream());
            Graphics2D g = image.createGraphics();
            int widthimg = image.getWidth() / 3;
            int heightimg = image.getHeight() / 3;
            // logo起始位置，此目的是为logo居中显示
            int x = (image.getWidth() - widthimg) / 2;
            int y = (image.getHeight() - heightimg) / 2;
            // 绘制图
            g.drawImage(logo, x, y, widthimg, heightimg, null);
            g.dispose();// 清理内存中的图片，返还内存给系统
            // 输出二维码
        }
        ImageIO.write(image, format, outputStream);
    }
}
