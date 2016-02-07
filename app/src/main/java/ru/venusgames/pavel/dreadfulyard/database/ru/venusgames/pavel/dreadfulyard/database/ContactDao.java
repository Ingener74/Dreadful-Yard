package ru.venusgames.pavel.dreadfulyard.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import ru.venusgames.pavel.dreadfulyard.database.Contact;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT".
*/
public class ContactDao extends AbstractDao<Contact, Long> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ContactUserId = new Property(1, String.class, "contactUserId", false, "CONTACT_USER_ID");
        public final static Property ContactPhoneNumber = new Property(2, String.class, "contactPhoneNumber", false, "CONTACT_PHONE_NUMBER");
        public final static Property ContactName = new Property(3, String.class, "contactName", false, "CONTACT_NAME");
        public final static Property ContactStatus = new Property(4, Integer.class, "contactStatus", false, "CONTACT_STATUS");
    };


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CONTACT_USER_ID\" TEXT," + // 1: contactUserId
                "\"CONTACT_PHONE_NUMBER\" TEXT," + // 2: contactPhoneNumber
                "\"CONTACT_NAME\" TEXT," + // 3: contactName
                "\"CONTACT_STATUS\" INTEGER);"); // 4: contactStatus
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String contactUserId = entity.getContactUserId();
        if (contactUserId != null) {
            stmt.bindString(2, contactUserId);
        }
 
        String contactPhoneNumber = entity.getContactPhoneNumber();
        if (contactPhoneNumber != null) {
            stmt.bindString(3, contactPhoneNumber);
        }
 
        String contactName = entity.getContactName();
        if (contactName != null) {
            stmt.bindString(4, contactName);
        }
 
        Integer contactStatus = entity.getContactStatus();
        if (contactStatus != null) {
            stmt.bindLong(5, contactStatus);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // contactUserId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // contactPhoneNumber
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // contactName
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4) // contactStatus
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setContactUserId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContactPhoneNumber(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContactName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContactStatus(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Contact entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Contact entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
