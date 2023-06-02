# SecureFileTransfer
Secure File Transmission Using Vigenère Cipher and SHA-512 Hashing Algorithm

# SYSTEM DESIGN
<img width="335" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/176b36e4-7f7e-4c3e-82f2-56e0eb1ebcfe">


# MODULES
Main Class : This class will contain the main method to start the application. It creates an instance of the GUI class and makes it visible.

FileTransferGUI : This class extends Frame and represents the main GUI window. It includes the components like labels, text fields, buttons, and text areas. It handles user actions, such as authentication, file selection, encryption, and decryption. It also contains methods for hashing passwords and encrypting/decrypting files.

FileEncryptor : This class handles the encryption of files using the Vigenere cipher. It includes methods for encrypting and decrypting byte arrays.

SHA512Hasher : This class provides methods for hashing passwords using the SHA-512 algorithm.


# OUTPUT

User Authentication

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/08a0520b-aa4b-49f1-ac55-11a4f53d754a">

Upload and  Encrypt File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/44448c9a-9a03-48f8-8d6d-1c16623d72f5">

Original File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/0377bdd2-89ca-49c8-a74b-40b7698141d9">

Encrypted File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/da859a46-d53c-4fc6-be2e-ad146ab042c0">

Decrypt file: Other User

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/c4bacd02-cde3-4c6a-adab-deabb4ca4715">

Decrypt File: Corrupted File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/7c0568e0-73b3-46e3-ab04-816e159054ac">

Decrypt file: Same User

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/36037f05-3530-4253-a337-d32a10c4ae29">

Decrypt File: Original File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/ebbee445-9234-4a2b-91ed-9a5fdb2d1c47">

Original Audio File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/7acb1401-8078-4f0b-9e88-abb6571c07fa">

Encrypted Audio File

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/786abbcf-be02-4e97-a08d-1aa699ca2574">

Decryption Audio File: Another user

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/534f95b2-a8ad-44bc-974f-f45ee5a96378">

Decryption Audio File: Same user

<img width="451" alt="image" src="https://github.com/sujigarasharma/SecureFileTransfer/assets/114681230/3c901c9c-407c-4808-9395-2d31fec81014">
