def ant = new AntBuilder().sequential {
        taskdef name:"groovyc", classname:"org.codehaus.groovy.ant.Groovyc"
        groovyc srcdir:"src", destdir:"web/WEB-INF/classes",{
                classpath {
                        fileset dir:"web/WEB-INF/lib",{ include name: "*.jar" }
                        pathelement path:"web/WEB-INF/classes"
                }
                javac source: "1.5", target: "1.5", debug: "on"
        }
}