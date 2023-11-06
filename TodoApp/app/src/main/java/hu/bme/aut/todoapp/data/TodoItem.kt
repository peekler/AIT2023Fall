package hu.bme.aut.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.bme.aut.todoapp.R
import java.io.Serializable


@Entity(tableName = "todotable")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "createdate") var createDate: String,
    @ColumnInfo(name = "todopriority") var priority: TodoPriority,
    @ColumnInfo(name = "isdone") var isDone: Boolean
) : Serializable

enum class TodoPriority {
    NORMAL, HIGH;

    fun getIcon(): Int {
        return if (this == NORMAL) R.drawable.normal else R.drawable.important
    }
}

