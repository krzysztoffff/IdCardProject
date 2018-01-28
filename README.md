# IdCardProject

<h2>Spring MVC with JPA Hibernate project.</h2>

<h2>Link:<br>
<a href="http://www.krzysztoffff.usermd.net/IdCardProject" target="blank">
http://www.krzysztoffff.usermd.net/IdCardProject</a></h2>


<h3>Installation instructions: <br><br>

In MySQL create manually databyse which correspondences with
src/main/resources/META-INF/persistence.xml

Edit DocumentsController.java to change project folder path to
your path e.g. <br>
private static String UPLOADED_FOLDER = "//usr//home//krzysztoffff//tomcat//webapps//IdCardProject//resources//images//";
</h3>
<br><br>
<h4>Functionality:</h4>
<ul>
<li>Create citizens databyse with CRUD.</li>
<li>Every operations on citizens are registered in citizen history with date and action name.</li>
<li>User can create a new ID document assigned to citizen with picture and some additional data.</li>
<li>Number of documents with picters are unlimited. Names of pictures files were granted unique.</li>
</ul>
<h4>Future functionality:</h4>
<ul>
<li>Acces with login and password encrypted by jbcrypt</li>
<li>Refactor project to Spring security.</li>
<li>Some additional functionalities wchich i don't know yet</li>
</ul>
