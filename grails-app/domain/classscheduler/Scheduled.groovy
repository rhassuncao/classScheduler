package classscheduler

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes=['name', 'subject', 'period'])
@ToString(includes=['name'], includeNames=true, includePackage=false)
class Scheduled {

    String name

    Subject subject
    Period period

    static belongsTo = [teacher: Teacher]

    static mapping = {
        teacher lazy: false
        subject lazy: false
        period  lazy: false

    }

    static constraints = {
    }
}