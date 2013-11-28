romaSpringAndroidSimpleProject
===========================
How to build a android application with Gradle and Maven

- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Links
    http://spring.io/guides/gs/android/
	http://spring.io/guides/gs/gradle-android/
	http://spring.io/guides/gs/maven-android/

		
   
1.
	Instal Android SDK.  It also installs the AVD Manager(a graphical user interface for creating and managing Android Virtual Devices (AVDs))
		http://developer.android.com/sdk/index.html
	Open Android SDK Manager
		$ android
	Select the latest Android SDK
		Install packages
	Create a new ADV (Android virtual device)
		android create avd --name Default --target 29 --abi armeabi-v7a
	Or go to Android SDK Manager
        -> Tools -> Manage ADV
        Craete a new avd
	List the ADVs
		android list avd

2. inside the package br.com.romalopes.springexamples
    Create the AndroiManifest.xml
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="br.com.romalopes.springexamples"
        android:versionCode="1"
        android:versionName="1.0.0" >

        <application android:label="@string/app_name" >
            <activity
                android:name=".HelloActivity"
                android:label="@string/app_name" >
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>
    </manifest>

3. Create a string resource   main/res/values/string.xml
    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <string name="app_name">Android Maven and Gradle</string>
    </resources>

4. Define the Layout of the project in main/res/layout/hello_layout.xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        >
        <TextView
        android:id="@+id/text_view"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        />
    </LinearLayout>

5. Create a activity class in src/main/java/br/com/romalopes/springexamples/HelloActivity.java
    public class HelloActivity extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.hello_layout);
        }

        @Override
        public void onStart() {
            super.onStart();
            TextView textView = (TextView) findViewById(R.id.text_view);
            textView.setText("Hello world!");
        }

    }


	
Maven
    $ mvn compile
    $ mvn package
    $ mvn android:help

Gradle
    $ gradlew tasks
    $ gradlew build
