package com.company.sakila.db0.sakila.film_text.generated;

import com.company.sakila.db0.sakila.film_text.FilmText;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.util.OptionalUtil;
import com.speedment.runtime.field.ShortField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;
import java.util.Optional;

/**
 * The generated base for the {@link
 * com.company.sakila.db0.sakila.film_text.FilmText}-interface representing
 * entities of the {@code film_text}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedFilmText {
    
    /**
     * This Field corresponds to the {@link FilmText} field that can be obtained
     * using the {@link FilmText#getFilmId()} method.
     */
    final ShortField<FilmText, Short> FILM_ID = ShortField.create(
        Identifier.FILM_ID,
        FilmText::getFilmId,
        FilmText::setFilmId,
        TypeMapper.primitive(), 
        true
    );
    /**
     * This Field corresponds to the {@link FilmText} field that can be obtained
     * using the {@link FilmText#getTitle()} method.
     */
    final StringField<FilmText, String> TITLE = StringField.create(
        Identifier.TITLE,
        FilmText::getTitle,
        FilmText::setTitle,
        TypeMapper.identity(), 
        false
    );
    /**
     * This Field corresponds to the {@link FilmText} field that can be obtained
     * using the {@link FilmText#getDescription()} method.
     */
    final StringField<FilmText, String> DESCRIPTION = StringField.create(
        Identifier.DESCRIPTION,
        o -> OptionalUtil.unwrap(o.getDescription()),
        FilmText::setDescription,
        TypeMapper.identity(), 
        false
    );
    
    /**
     * Returns the filmId of this FilmText. The filmId field corresponds to the
     * database column db0.sakila.film_text.film_id.
     * 
     * @return the filmId of this FilmText
     */
    short getFilmId();
    
    /**
     * Returns the title of this FilmText. The title field corresponds to the
     * database column db0.sakila.film_text.title.
     * 
     * @return the title of this FilmText
     */
    String getTitle();
    
    /**
     * Returns the description of this FilmText. The description field
     * corresponds to the database column db0.sakila.film_text.description.
     * 
     * @return the description of this FilmText
     */
    Optional<String> getDescription();
    
    /**
     * Sets the filmId of this FilmText. The filmId field corresponds to the
     * database column db0.sakila.film_text.film_id.
     * 
     * @param filmId to set of this FilmText
     * @return       this FilmText instance
     */
    FilmText setFilmId(short filmId);
    
    /**
     * Sets the title of this FilmText. The title field corresponds to the
     * database column db0.sakila.film_text.title.
     * 
     * @param title to set of this FilmText
     * @return      this FilmText instance
     */
    FilmText setTitle(String title);
    
    /**
     * Sets the description of this FilmText. The description field corresponds
     * to the database column db0.sakila.film_text.description.
     * 
     * @param description to set of this FilmText
     * @return            this FilmText instance
     */
    FilmText setDescription(String description);
    
    enum Identifier implements ColumnIdentifier<FilmText> {
        
        FILM_ID     ("film_id"),
        TITLE       ("title"),
        DESCRIPTION ("description");
        
        private final String columnName;
        private final TableIdentifier<FilmText> tableIdentifier;
        
        Identifier(String columnName) {
            this.columnName      = columnName;
            this.tableIdentifier = TableIdentifier.of(    getDbmsName(), 
                getSchemaName(), 
                getTableName());
        }
        
        @Override
        public String getDbmsName() {
            return "db0";
        }
        
        @Override
        public String getSchemaName() {
            return "sakila";
        }
        
        @Override
        public String getTableName() {
            return "film_text";
        }
        
        @Override
        public String getColumnName() {
            return this.columnName;
        }
        
        @Override
        public TableIdentifier<FilmText> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}