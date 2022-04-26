package br.com.mind5.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.action.EmpVisiMergeAddress;
import br.com.mind5.business.employee.model.action.EmpVisiMergeEmpwotm;
import br.com.mind5.business.employee.model.action.EmpVisiMergeFimist;
import br.com.mind5.business.employee.model.action.EmpVisiMergePerson;
import br.com.mind5.business.employee.model.action.EmpVisiMergePhone;
import br.com.mind5.business.employee.model.action.EmpVisiMergeToSelect;
import br.com.mind5.business.employee.model.action.EmpVisiMergeUser;
import br.com.mind5.business.employee.model.action.EmpVisiNodeSytotauh;
import br.com.mind5.business.employee.model.checker.EmpCheckLangu;
import br.com.mind5.business.employee.model.checker.EmpCheckOwner;
import br.com.mind5.business.employee.model.checker.EmpCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmpRootSelect extends DeciTreeTemplateRead<EmpInfo> {
	
	public EmpRootSelect(DeciTreeOption<EmpInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmpInfo> buildCheckerHook(DeciTreeOption<EmpInfo> option) {
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmpCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmpCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmpInfo>> buildActionsOnPassedHook(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();

		ActionStd<EmpInfo> select = new ActionStdCommom<EmpInfo>(option, EmpVisiMergeToSelect.class);
		ActionLazy<EmpInfo> nodeSytotauh = new ActionLazyCommom<EmpInfo>(option, EmpVisiNodeSytotauh.class);
		ActionLazy<EmpInfo> mergePerson = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergePerson.class);
		ActionLazy<EmpInfo> mergeAddress = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeAddress.class);
		ActionLazy<EmpInfo> mergePhone = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergePhone.class);
		ActionLazy<EmpInfo> mergeUser = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeUser.class);
		ActionLazy<EmpInfo> mergeFimist = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeFimist.class);
		ActionLazy<EmpInfo> mergeEmpwotm = new ActionLazyCommom<EmpInfo>(option, EmpVisiMergeEmpwotm.class);
		
		select.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeFimist);
		mergeFimist.addPostAction(mergeEmpwotm);
		
		actions.add(select);
		return actions;
	}
}
