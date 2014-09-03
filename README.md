Sheath
======

A very very simple static wrapper for [Dagger](https://github.com/square/dagger).


Usage
--------

This was made with Android development in mind because I didn't like writing static getters for my Application contexts in order to inject new entities into the object graph.

First you must call holster with all your modules before you can inject anything.

```
public class WearableManagerApplication extends Application {
    public void onCreate() {
        super.onCreate();

        // You are now ready to wield your Dagger
        Sheath.holster(new ModuleOne(), new ModuleTwo());
    }
}
```
After holster is called you can now inject your objects

```
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

```
<dependency>
	<groupId>io.pristine.sheath</groupId>
	<artifactId>sheath</artifactId>
	<version>{latest-version}</version>
</dependency>
```

Gradle

```
compile 'io.pristine.sheath:sheath:{latest-version}'
```