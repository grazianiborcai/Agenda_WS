package br.com.gda.business.person.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class PersonMergerUsername extends InfoMerger_<PersonInfo, UsernameInfo, PersonInfo> {
	public PersonInfo merge(UsernameInfo sourceOne, PersonInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonVisiMergeUsername());
	}
	
	
	
	public List<PersonInfo> merge(List<UsernameInfo> sourceOnes, List<PersonInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonVisiMergeUsername());
	}
}
