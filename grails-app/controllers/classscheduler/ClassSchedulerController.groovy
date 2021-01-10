package classscheduler

class ClassSchedulerController {

    ScheduledService scheduledService

    static allowedMethods = [index: "GET", create: "POST"]

    def index(Integer max) {

        params.max = Math.min(max ?: 10, 100)
        respond scheduledService.list(params), model:[scheduledCount: scheduledService.count()]
    }

    def create() {
        scheduledService.save(params)

        redirect(action: "index")
    }
}