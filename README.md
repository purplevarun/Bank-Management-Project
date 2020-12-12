<h1 >Bank Management Project</h1>
<h4>Full Stack Java Application for a Bank Management System.</h4>
<h4>Technologies used :- Java, Swing, MySQL as database, Java AWT concepts.</h4>
<h5>NOTE : This is a very detailed documentation of the project and not an overview.</h5>
<h4>To run the project, use command "java -jar bank_management_project.jar" after creating databases.</h4>
<h2>INITIAL LOGIN PAGE</h2>
<img src="https://user-images.githubusercontent.com/39029055/99880995-ed8c8000-2c3c-11eb-8a21-d84c175d6671.png">
<h3>Before using the application, we need to create our relational databases. Here, MySQL has been used.</h3>
<h2>4 databases need to be created :</h2>
<img src="https://user-images.githubusercontent.com/39029055/99879564-d39a6f80-2c33-11eb-8a88-363b0661a82c.png">
<h3>LOGIN TABLE:</h3>
<img src="https://user-images.githubusercontent.com/39029055/99879644-3855ca00-2c34-11eb-8e09-fbf7318ccf05.png">
<h3>SIGNUP TABLE</h3>
<img src="https://user-images.githubusercontent.com/39029055/99879646-3986f700-2c34-11eb-9f0b-73f55fa0a4a8.png">
<h3>SIGNUP TABLE 2</h3>
<img src="https://user-images.githubusercontent.com/39029055/99879647-3a1f8d80-2c34-11eb-89ee-e3b22aeb1eb1.png">
<h3>STATEMENT TABLE</h3>
<img src="https://user-images.githubusercontent.com/39029055/99879648-3a1f8d80-2c34-11eb-987e-4b062a743160.png">
<h2>To proceed , one needs to sign up and create a bank account</h2>
<img src="https://user-images.githubusercontent.com/39029055/99880903-49a2d480-2c3c-11eb-9447-493a1bcb65c9.png">
<h3>IF WE DON'T AGREE TO TERMS AND CONDITIONS :</h3>
<img src="https://user-images.githubusercontent.com/39029055/99880933-81aa1780-2c3c-11eb-9270-182547313a7d.png">
<h3>WHEN WE AGREE TO TERMS AND CONDITIONS, we are signed up and recieve a unique card number and PIN (all randomly generated)</h3>
<img src="https://user-images.githubusercontent.com/39029055/99880963-c6ce4980-2c3c-11eb-8db4-cebeb32929ce.png">
<h2>Naturally, all our information is stored in the database:</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881026-26c4f000-2c3d-11eb-8abf-efa0fe20e43f.png">
<img src="https://user-images.githubusercontent.com/39029055/99881032-36dccf80-2c3d-11eb-8a38-72792d8f7527.png">
<img src="https://user-images.githubusercontent.com/39029055/99881042-4f4cea00-2c3d-11eb-8317-e08a9df60a10.png">
<h2>We are redirected to the Login Page</h2>
<img src="https://user-images.githubusercontent.com/39029055/99880995-ed8c8000-2c3c-11eb-8a21-d84c175d6671.png">
<h2>Upon entering correct credentials:</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881084-7c010180-2c3d-11eb-83a4-9d9350dffd58.png">
<h2>This is the main window (ie.)THE TRANSACTION WINDOW. You can check balance by clicking on the top button</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881105-989d3980-2c3d-11eb-8201-ff742dbf7cf1.png">
<h2>THE DEPOSIT WINDOW</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881131-c6827e00-2c3d-11eb-9adb-56dfc6d382f6.png">
<h2>If we withdraw more than we have:-</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881144-e44fe300-2c3d-11eb-8035-0b87d42f25cb.png">
<h2>If we withdraw correctly:</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881157-ffbaee00-2c3d-11eb-9457-81f46ea4ef54.png">
<h2>This is the Records Book, it contains the two transactions we just performed :-</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881171-1cefbc80-2c3e-11eb-8e67-2e397bcdb733.png">
<h2>After some more transactions:</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881193-49a3d400-2c3e-11eb-8a2f-c678ad14cc63.png">
<h2>Notice how the font and line spacing decreases as the number of transactions also increase...</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881209-68a26600-2c3e-11eb-84cc-9ae753abbfa3.png">
<h2>Also, the whole record book and all details are stored in the database.</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881232-8a9be880-2c3e-11eb-871c-c2d14dead1fb.png">
<h2>Now if we want to change our 4 digit PIN.. -></h2>
<img src="https://user-images.githubusercontent.com/39029055/99881254-ad2e0180-2c3e-11eb-8a68-3ae7486d004c.png">
<h2>Ofcourse, if the new pin and the confirmational pin don't match..</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881277-c3d45880-2c3e-11eb-84db-3e6a207982c7.png">
<h2>When they match, old pin is deleted and new pin is stored</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881291-de0e3680-2c3e-11eb-96a0-6ab4d2388829.png">
<h2>Old pin is completely deleted, even from the database, so that no one can login using the old pin.</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881307-fd0cc880-2c3e-11eb-89f6-ac19435edf12.png">
<h2>If we try to login using our old pin (2059)</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881331-1ca3f100-2c3f-11eb-99f9-5afa5fa0f66b.png">
<h2>When we login using new pin :-</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881354-4f4de980-2c3f-11eb-844c-1beaed727b99.png">
<h2>As you can see, all data is intact</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881365-61c82300-2c3f-11eb-803f-f3ccf9a69cac.png">
<h2>And last but not the least, a credits page.</h2>
<img src="https://user-images.githubusercontent.com/39029055/99881386-8d4b0d80-2c3f-11eb-92b2-29202a21da18.png">
