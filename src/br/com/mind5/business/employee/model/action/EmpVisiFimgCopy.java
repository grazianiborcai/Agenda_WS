package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.file.fileImage.info.FimgCopier;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.model.decisionTree.FimgRootCopyToEmp;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiFimgCopy extends ActionVisitorTemplateAction<EmpInfo, FimgInfo> {
	
	public EmpVisiFimgCopy(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgInfo>> getTreeClassHook() {
		return FimgRootCopyToEmp.class;
	}
	
	
	
	@Override protected List<FimgInfo> toActionClassHook(List<EmpInfo> baseInfos) {
		return FimgCopier.copyFromEmp(baseInfos);
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<FimgInfo> results) {
		return baseInfos;
	}
}
