package classscheduler

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@GrailsCompileStatic
@EqualsAndHashCode(includes=['name'])
@ToString(includes=['name'], includeNames=true, includePackage=false)
class Teacher {

    String name

    static hasMany = [ units: Scheduled ]

    static constraints = {
        units nullable: true
    }
}