# DownloadAPI
Simple SpringBoot API to download files with a UUID to validate the download 

# DownloadAPI
Simple SpringBoot API with following functions:
- h2 database enumerates files in downloads and assigns each file 3 download UUIDs
- download files with a UUID to validate the upload
- one UUID = one specific file download
- UUIDs get "used" after one download, rejecting further uses

## Setup
1. Verify dependencies are met (Java, Gradle, & etc.)
2. Download the boilerplate code setup from [here](https://github.com/i-vt/SpringBootTemplate/)
3. Copy-paste this repo files on top of the boilerplate files (replacing them if needed)
4. Change default H2 password (optional disable H2 public page)
5. Test it
6. (Optional) ChatGPT whatever tf broke in the process

## Testing
1. Log into http://localhost:8080/h2-console with default creds:
```
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: password
```
2. Identify the file you are interested in `SELECT * FROM FILE_ENTITY `
```
ID  	FILE_NAME  
1	txttest.txt
2	test.txt
```
3. Get the file UUID
`SELECT * FROM FILE_DOWNLOADUUID`
```
TRUE	1	eb3b69ea-3d3f-410c-900f-1082f64db35b
FALSE	1	2cdad145-6c90-4845-8f6c-fd6fb673ba77
FALSE	1	63351bdf-4e18-4283-815b-8275e592e368
FALSE	2	e73f6713-ef70-4984-ad1d-37afc0a93eb1
FALSE	2	430b9b27-c2ca-4e0d-b326-c6f1a56856f0
FALSE	2	1b952046-dfbd-4e90-a263-5b960ca16d01
```

4. Testing it with curl:
```
curl -O -J -L http://localhost:8080/api/files/download/430b9b27-c2ca-4e0d-b326-c6f1a56856f0
```

If success you get a file download that you wanted, if the UUID is invalid you get:
```{"timestamp":"2024-09-30T20:50:23.843+00:00","status":500,"error":"Internal Server Error","path":"/api/files/download/eb3b69ea-3 ```


## Disclaimer for "DownloadAPI":

### Summary:
Exercise responsibility and abide by legal standards while using this software. Unauthorized penetration testing is prohibited and illegal.

### In depth:

- General Use: This software is provided "as is", without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, and non-infringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the software.
- Potential Misuse: The software is designed for legitimate purposes only. Any misuse, including but not limited to illegal, unethical, or unauthorized activities, is strictly discouraged and not the intention of the developers.
- User Responsibility: Any person, entity, or organization choosing to use this software bears the full responsibility for its actions while using the software. It is the user's responsibility to ensure that their use of this software complies with local, state, national, and international laws and regulations.
- No Liability: The creators, developers, and distributors of this software are not responsible for any harm or damage caused, directly or indirectly, by the misuse or use of this software.
- Updates and Monitoring: The developers reserve the right to update, modify, or discontinue the software at any time. Users are advised to always use the most recent version of the software. However, even with updates, the developers cannot guarantee that the software is completely secure or free from vulnerabilities.
- Third-Party Software/Links: This software may contain links to third-party sites or utilize third-party software/tools. The developers are not responsible for the content or privacy practices of those sites or software.
- Unauthorized Access: Using "DownloadAPI" to access, probe, or connect to systems, networks, or data without explicit permission from appropriate parties is strictly discouraged, unethical, and illegal. Unauthorized access to systems, networks, or data breaches various local, national, and international laws, and can result in severe legal consequences. Always obtain the necessary permissions before accessing any systems or data. The developers of "DownloadAPI" disavow any actions taken by individuals or entities that use this software for unauthorized activities.

By downloading, installing, or using "DownloadAPI" you acknowledge that you have read, understood, and agreed to abide by this disclaimer. If you do not agree to these terms, do not use the software.
