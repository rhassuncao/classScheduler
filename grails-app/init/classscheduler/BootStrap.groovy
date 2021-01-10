package classscheduler

import classscheduler.Teacher
import classscheduler.Period
import classscheduler.Subject
import classscheduler.Scheduled

class BootStrap {

    def init = { servletContext ->
        log.info "Loading database..."
        final Teacher teacher1 = new Teacher(name: "Mary").save(failonError: true)
        final Teacher teacher2 = new Teacher(name: "Tyler").save(failonError: true)
        final Teacher teacher3 = new Teacher(name: "Morrison").save(failonError: true)
        final Teacher teacher4 = new Teacher(name: "Stephanie").save(failonError: true)

        final Period first = new Period(name: "First").save(failonError: true)
        final Period second = new Period(name: "Second").save(failonError: true)
        final Period third = new Period(name: "Third").save(failonError: true)
        final Period fourth = new Period(name: "Fourth").save(failonError: true)
        final Period fifth = new Period(name: "Fifth").save(failonError: true)
        final Period sixth = new Period(name: "Sixth").save(failonError: true)
        final Period seventh = new Period(name: "Seventh").save(failonError: true)

        final Subject history1 = new Subject(name: "World History").save(failonError: true)
        final Subject history2 = new Subject(name: "Government").save(failonError: true)
        final Subject science1 = new Subject(name: "Natural Science").save(failonError: true)
        final Subject science2 = new Subject(name: "Biology").save(failonError: true)
        final Subject math1 = new Subject(name: "Algebra 1").save(failonError: true)
        final Subject math2 = new Subject(name: "Algebra 2").save(failonError: true)
        final Subject math3 = new Subject(name: "Pre Calc").save(failonError: true)
        final Subject math4 = new Subject(name: "Calculus").save(failonError: true)

        new Scheduled(name: "Room 1", teacher: teacher1, period: first, subject: history1).save(failonError: true)
        new Scheduled(name: "Room 2", teacher: teacher1, period: second, subject: science1).save(failonError: true)
        new Scheduled(name: "Room 3", teacher: teacher2, period: first, subject: math1).save(failonError: true)
    }
    def destroy = {
    }
}