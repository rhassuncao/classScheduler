package classscheduler

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // "/"(view:"/index")

        "/"(controller: "classScheduler")
        "/create"(controller: "classScheduler", action: "create")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}