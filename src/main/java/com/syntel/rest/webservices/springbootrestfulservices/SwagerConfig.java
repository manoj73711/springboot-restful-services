package com.syntel.rest.webservices.springbootrestfulservices;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.annotations.Info;

//this below is one way of configuring
/*@SwaggerDefinition(
        info = @Info(
                description = "Awsome Syntel API",
                version = "1.0.0",
                title = "This is Awsome API",
                termsOfService = "http://syntelterms.io/terms.html",
                contact = @Contact(
                   name = "Manoj kumar", 
                   email = "info@syntel.com", 
                   url = "http://syntel.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}       
)*/
public interface SwagerConfig {

}
