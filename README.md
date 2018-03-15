# Neo4jOgmEntityMappingExample

This branch `fast-classpath-scanner` in particular shows that 
the underlying issue with the Neo OGM and Scala is **an outdated FastClasspathScanner**. Manually specifying the most
up-to-date version of the scanner fixes the issue!!!

This project displays an [issue with the Neo4j OGM](https://github.com/neo4j/neo4j-ogm/issues/474) when loading persistent NodeEntity Classes


To run:
```
git clone https://github.com/skyferthesly/Neo4jOgmEntityMappingExample
cd Neo4jOgmEntityMappingExample
sbt run
```

Which presents the following stacktrace:

```
[info] Running testdomain.Test
2018-03-08 13:54:09 INFO  DomainInfo:160 - Starting Post-processing phase
2018-03-08 13:54:09 INFO  DomainInfo:126 - Building annotation class map
2018-03-08 13:54:09 INFO  DomainInfo:139 - Building interface class map for 0 classes
2018-03-08 13:54:09 INFO  DomainInfo:215 - Post-processing complete
[error] (run-main-0) java.lang.IllegalArgumentException: Class class testdomain.Person is not a valid entity class. Please check the entity mapping.
[error] java.lang.IllegalArgumentException: Class class testdomain.Person is not a valid entity class. Please check the entity mapping.
[error]         at org.neo4j.ogm.session.delegates.SaveDelegate.save(SaveDelegate.java:88)
[error]         at org.neo4j.ogm.session.delegates.SaveDelegate.save(SaveDelegate.java:40)
[error]         at org.neo4j.ogm.session.Neo4jSession.save(Neo4jSession.java:469)
[error]         at testdomain.Test$.delayedEndpoint$testdomain$Test$1(Test.scala:32)
[error]         at testdomain.Test$delayedInit$body.apply(Test.scala:26)
[error]         at scala.Function0.apply$mcV$sp(Function0.scala:34)
[error]         at scala.Function0.apply$mcV$sp$(Function0.scala:34)
[error]         at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
[error]         at scala.App.$anonfun$main$1$adapted(App.scala:76)
[error]         at scala.collection.immutable.List.foreach(List.scala:389)
[error]         at scala.App.main(App.scala:76)
[error]         at scala.App.main$(App.scala:74)
[error]         at testdomain.Test$.main(Test.scala:26)
[error]         at testdomain.Test.main(Test.scala)
[error]         at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
[error]         at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
[error]         at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
[error]         at java.lang.reflect.Method.invoke(Unknown Source)
[error]         at sbt.Run.invokeMain(Run.scala:93)
[error]         at sbt.Run.run0(Run.scala:87)
[error]         at sbt.Run.execute$1(Run.scala:65)
[error]         at sbt.Run.$anonfun$run$4(Run.scala:77)
[error]         at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:12)
[error]         at sbt.util.InterfaceUtil$$anon$1.get(InterfaceUtil.scala:10)
[error]         at sbt.TrapExit$App.run(TrapExit.scala:252)
[error]         at java.lang.Thread.run(Unknown Source)
[error] java.lang.RuntimeException: Nonzero exit code: 1
[error]         at sbt.Run$.executeTrapExit(Run.scala:124)
[error]         at sbt.Run.run(Run.scala:77)
[error]         at sbt.Defaults$.$anonfun$bgRunTask$5(Defaults.scala:1169)
[error]         at sbt.Defaults$.$anonfun$bgRunTask$5$adapted(Defaults.scala:1164)
[error]         at sbt.internal.BackgroundThreadPool.$anonfun$run$1(DefaultBackgroundJobService.scala:366)
[error]         at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:12)
[error]         at scala.util.Try$.apply(Try.scala:209)
[error]         at sbt.internal.BackgroundThreadPool$BackgroundRunnable.run(DefaultBackgroundJobService.scala:289)
[error]         at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
[error]         at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
[error]         at java.lang.Thread.run(Unknown Source)
[error] (Compile / run) Nonzero exit code: 1
[error] Total time: 6 s, completed Mar 8, 2018 1:54:09 PM
```

The entire project is in one file. How can `Person` not be loaded into the class map?