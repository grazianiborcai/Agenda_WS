package br.com.mind5.business.employeeList.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisMergerFimist extends InfoMergerTemplate<EmplisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, FimistInfo> getVisitorHook() {
		return new EmplisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
