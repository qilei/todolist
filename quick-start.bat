set MVN=mvn
call %MVN% clean install -Dmaven.test.skip=true
call %MVN% eclipse:clean eclipse:eclipse -Dwtpversion=2.0

pause