package com.link.common.plugin.swagger.model;

/**
 * [description]
 *
 * @author lee
 * @version V1.0.0
 * @date 2017/7/6
 */
public class SwaggerResponse {
    private String description;

    private Schema schema;

    public SwaggerResponse(String description) {
        this.description = description;
    }

    public SwaggerResponse(Schema schema) {
        this.schema = schema;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public static class Schema {
        private String type;
        private Items items;

        public Schema(String type, Items items) {
            this.type = type;
            this.items = items;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }
    }

    public static class Items {
        private String $ref;

        public Items(String ref) {
            this.$ref = ref;
        }

        public String get$ref() {
            return $ref;
        }

        public void set$ref(String $ref) {
            this.$ref = $ref;
        }
    }
}
