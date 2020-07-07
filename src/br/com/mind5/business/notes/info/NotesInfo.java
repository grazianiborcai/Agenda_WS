package br.com.mind5.business.notes.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class NotesInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codNote;
	public String note;
	public boolean isDeleted;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public NotesInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codNote = DefaultValue.number();
		isDeleted = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	
	
	public static NotesInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, NotesInfo.class);
	}
	
	
	
	public static List<NotesInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, NotesInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codNote 	^ (codNote 	>>> 32));
		
		if (codLanguage != null)
			result = result * 31 + codLanguage.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof NotesInfo))
			return false;
		
		
		NotesInfo obj = (NotesInfo) o;		
		return (codOwner == obj.codOwner 	&& 
				codNote   == obj.codNote		&&
				super.isStringEqual(codLanguage, obj.codLanguage));
	}
}
