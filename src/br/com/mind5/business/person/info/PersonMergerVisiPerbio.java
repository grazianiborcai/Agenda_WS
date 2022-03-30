package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PersonMergerVisiPerbio extends InfoMergerVisitorTemplate<PersonInfo, PerbioInfo> {
	
	@Override protected List<PersonInfo> beforeMergeHook(List<PersonInfo> baseInfos) {
		for (PersonInfo eachBase : baseInfos) {
			eachBase.perbios = DefaultValue.list();
		}
		
		return baseInfos;
	}
	
	

	@Override public boolean shouldMerge(PersonInfo baseInfo, PerbioInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner		&&
				baseInfo.codPerson == selectedInfo.codPerson		);
	}
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, PerbioInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		baseInfo.perbios.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
