Sheath
======

A very very simple static wrapper for [Dagger](https://github.com/square/dagger).


Usage
--------

This was made with Android development in mind because I didn't like writing static getters for my Application contexts in order to inject new entities into the object graph.

First you must call holster with all your modules before you can inject anything.

```java
public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();

        // You are now ready to wield your Dagger
        Sheath.holster(new ModuleOne(), new ModuleTwo());
    }
}
```

After holster is called you can now inject your objects

```java
public class MyActivity extends Activity {
    public void onCreate() {
        super.onCreate();

        Sheath.inject(this);
    }
}
```

Download
--------
Including Sheath in your project gives you Dagger so don't worry about including it unless you want a specific version of Dagger. If you are doing this be sure to exclude the version of Dagger included with Sheath.

Maven

```xml
<dependency>
	<groupId>io.pristine.sheath</groupId>
	<artifactId>sheath</artifactId>
	<version>{latest-version}</version>
</dependency>
```

Gradle

```groovy
compile 'io.pristine.sheath:sheath:{latest-version}'
```

License
-------
Copyright 2014-2015, [Pristine Inc.](https://pristine.io/)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
