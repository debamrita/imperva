1.	Tests can be run either by from IDE or using command line (mvn clean install )
2.	The params are injected from TestNG.xml eg if user has to run on different browser or want to run on local or remote
3.	The browser profile is created from InVokeBrowser.java under common package
4.	On failure screenshot is being taken
5.	On failure the tests re run RetryListner is under listners package and being called from TestNG.xml
6.  This framework uses Page Object Model, pages and the locators are present in side pages package
7.	Tests are inside test and extends ConfigParameters.java for common methods
8.  Data is being pushed from data provider, depending upon data set.
