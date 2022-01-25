package br.com.mind5.business.personList.info;

import java.time.LocalDate;
import java.util.List;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PersolisInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public long codPerson;
	public long codSnapshot;
	public String cpf;
	public String name;
	public String nameDisplay;
	public String email;
	public LocalDate birthDate;
	public int birthYear;
	public int birthMonth;
	public int birthDay;
	public PerbiolisInfo perbiolisData;
	public String recordMode;
	public String username;
	
	
	public PersolisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codPerson = DefaultValue.number();	
		birthYear = DefaultValue.number();
		birthMonth = DefaultValue.number();
		birthDay = DefaultValue.number();
		perbiolisData = DefaultValue.object();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PersolisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, PersolisInfo.class);
	}
	
	
	
	public static List<PersolisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, PersolisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		PersolisInfo deepCopy = (PersolisInfo) super.clone();
		
		deepCopy.perbiolisData = CloneUtil.cloneRecord(deepCopy.perbiolisData, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codPerson ^ (codPerson >>> 32));
		
		if (name != null)
			result = result * 31 + name.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PersolisInfo))
			return false;
		
		
		PersolisInfo obj = (PersolisInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codPerson 	== obj.codPerson	&&
				super.isStringEqual(name, obj.name));
	}
}
