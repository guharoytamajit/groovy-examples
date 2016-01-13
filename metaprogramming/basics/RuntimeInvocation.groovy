class Person{
String name
def sleep(n,u){ println "sleeping for $n $u"}
static def dance(){ println "dancing"}
}

Person.metaClass.eat={-> println  "eating"}
Person.metaClass.age=10

per = new Person(name:"jim")

 if(per.metaClass.respondsTo(per,'sleep',1,"")){
 //only call sleep if it exists
 per.metaClass.getMetaMethod('sleep',1,"").invoke(per,2,"hrs")
}

 per.metaClass.getMetaMethod('eat').invoke(per)
 
 per.metaClass.getMetaMethod('dance').invoke(Person.class)
 
 
 println per.metaClass.getMetaProperty('name').getProperty(per)
 
  if(per.metaClass.hasProperty(per,'age')){
   //if age property exists print it
  println per.metaClass.getMetaProperty('age').getProperty(per)
  }

println "Methods : "+per.metaClass.getMethods()*.name
println "Properties : "+per.metaClass.getProperties()*.name
println "Properties of per are: "
per.properties.each { println it }