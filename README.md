# Crayons
Creating Repository for Crayons data for their assignment
Rest API exposed for adding notes,tag, adding tag to notes and their preliminary checks.

*please create a DB named postgres, i used Postgres DB and if needed change to any DB using applicaiton.properties.

Database: postgres
==================

Creating note
==============
Method: POST
URL: http://localhost:8080/note
Request Body:
{
    "content":"example notes",
    "noteId":1
}

Response:
========
{
    "notesId": 1,
    "content": "example notes",
    "noteId": "8",
    "tag": null,
    "createdOn": "2022-05-09T14:06:56.832325",
    "updatedOn": "2022-05-09T14:06:56.832473"
}
Creating Tag
============
Method: POST:
URL: http://localhost:8080/tag
Request Body: {
    "name":"Education"
    }
 Response:
 {
    "id": 1,
    "name": "Education"
}
Add tag to the Existing note:
=============================
Method: PUT
Request URL: http://localhost:8080/note/1
format:http://localhost:8080/note/{notesId}
Request Body:
{
    "id":2,
"name":"class"
}
Response:
{
    "notesId": 1,
    "content": "example notes",
    "noteId": "1",
    "tag": [
        {
            "id": 1,
            "name": "Education"
        },
        {
            "id": 1,
            "name": "class"
        }
    ],
    "createdOn": "2022-05-09T14:06:56.832325",
    "updatedOn": "2022-05-09T14:06:56.832473"
}
Get Tagged/All notes:
====================

Method: GET
Request URL: http://localhost:8080/getTaggedNotes?c1=class&c2=Education
format:http://localhost:8080/getTaggedNotes?c1={tagname1}&c2={tagname2}
Request Body:NA
Response:
[
    {
        "notesId": 1,
        "content": "example notes",
        "noteId": "8",
        "tag": [
            {
                "id": 5,
                "name": "5exampletag"
            },
            {
                "id": 1,
                "name": "exampletag"
            },
            {
                "id": 3,
                "name": "3exampletag"
            },
            {
                "id": 2,
                "name": "1exampletag"
            },
            {
                "id": 4,
                "name": "4exampletag"
            }
        ],
        "createdOn": "2022-05-09T14:06:56.832325",
        "updatedOn": "2022-05-09T14:06:56.832473"
    },
    {
        "notesId": 1,
        "content": "example notes",
        "noteId": "8",
        "tag": [
           
            {
                "id": 1,
                "name": "Education"
            },
            {
                "id": 2,
                "name": "class"
            }
        ],
        "createdOn": "2022-05-09T14:06:56.832325",
        "updatedOn": "2022-05-09T14:06:56.832473"
    }
]
if both c1 and c2 are null it will fetch all the notes
Example URL: http://localhost:8080/getTaggedNotes?c1=&c2=

** ADDING more than 5 tags is restricted and it will not add and will send the exisiting non altered object **
