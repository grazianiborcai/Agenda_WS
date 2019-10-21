package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class PersonapMergerGender extends InfoMergerTemplate<PersonapInfo, GenderInfo> {

	@Override protected InfoMergerVisitor<PersonapInfo, GenderInfo> getVisitorHook() {
		return new PersonapVisiMergeGender();
	}
}
