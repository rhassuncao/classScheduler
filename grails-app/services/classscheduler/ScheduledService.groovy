package classscheduler

import grails.gorm.transactions.Transactional

@Transactional
class ScheduledService {

    List<Scheduled> list(Map params) {
        try {
            Scheduled.list()
        } catch (Exception e) {
            log.error(e.message)
            []
        }
    }

    def count() {
        try {
            Scheduled.count()
        } catch (Exception e) {
            log.error(e.message)
            0
        }
    }

    def save(Map params) {
        try {
            println params
            final Period period = Period.get((String) params?.period?.id)
            final Subject subject = Subject.get((String) params?.subject?.id)
            final Teacher teacher = Teacher.get((String) params?.teacher?.id)

            new Scheduled(name: params.name, subject: subject, period: period, teacher: teacher).save(failOnError: true)
            true
        } catch (Exception e) {
            log.error(e.message)
            false
        }
    }
}