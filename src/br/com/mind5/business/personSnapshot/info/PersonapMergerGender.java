package br.com.mind5.business.personSnapshot.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.masterData.gender.info.GenderInfo;

final class PersonapMergerGender extends InfoMergerTemplate_<PersonapInfo, GenderInfo> {

	@Override protected InfoMergerVisitor_<PersonapInfo, GenderInfo> getVisitorHook() {
		return new PersonapVisiMergeGender();
	}
}
