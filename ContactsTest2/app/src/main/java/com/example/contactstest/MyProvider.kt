package com.example.contactstest

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.media.projection.MediaProjection
import android.net.Uri

class MyProvider:ContentProvider() {

    private val tableDir=0
    private val table1Item=1
    private val table2Dir=2
    private val table2Item=3

    private val uriMatcher=UriMatcher(UriMatcher.NO_MATCH)

    init {
        uriMatcher.addURI("com.example.app.provider","table1",tableDir)
        uriMatcher.addURI("com.example.app.provider","table1/#",table1Item)
        uriMatcher.addURI("com.example.app.provider","table2",table2Dir)
        uriMatcher.addURI("com.example.app.provider","table2/#",table2Item)
    }
    override fun onCreate(): Boolean {
        return false
    }
/*
    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        when(uriMatcher.match(uri)){
            tableDir->{

            }
            table1Item->{

            }
            table2Dir->{

            }
            table2Item->{

            }

        }
    }
*/
    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun getType(uri: Uri)=when(uriMatcher.match(uri)){
        tableDir->"vnd.android.cursor.dir/vnd.com.example.app.provider.table1"
        table1Item->"vnd.android.cursor.item/vnd.com.example.app.provider.table1"
        table2Dir->"vnd.android.cursor.dir/vnd.com.example.app.provider.table2"
        table2Item->"vnd.android.cursor.item/vnd.com.example.app.provider.table2"
        else->null
    }
}