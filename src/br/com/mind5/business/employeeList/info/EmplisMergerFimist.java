package br.com.mind5.business.employeeList.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisMergerFimist extends InfoMergerTemplate_<EmplisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<EmplisInfo, FimistInfo> getVisitorHook() {
		return new EmplisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
