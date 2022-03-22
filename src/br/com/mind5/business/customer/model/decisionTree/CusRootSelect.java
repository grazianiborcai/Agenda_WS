package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.CusVisiMergeAddress;
import br.com.mind5.business.customer.model.action.CusVisiMergeCutefilon;
import br.com.mind5.business.customer.model.action.CusVisiMergeFimist;
import br.com.mind5.business.customer.model.action.CusVisiMergePerson;
import br.com.mind5.business.customer.model.action.CusVisiMergePet;
import br.com.mind5.business.customer.model.action.CusVisiMergePhone;
import br.com.mind5.business.customer.model.action.CusVisiMergeToSelect;
import br.com.mind5.business.customer.model.action.CusVisiNodeSytotauh;
import br.com.mind5.business.customer.model.action.CusVisiNodeUser;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CusRootSelect extends DeciTreeTemplateRead<CusInfo> {
	
	public CusRootSelect(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new CusCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> select = new ActionStdCommom<CusInfo>(option, CusVisiMergeToSelect.class);
		ActionLazy<CusInfo> nodeSytotauh = new ActionLazyCommom<CusInfo>(option, CusVisiNodeSytotauh.class);
		ActionLazy<CusInfo> mergePerson = new ActionLazyCommom<CusInfo>(option, CusVisiMergePerson.class);
		ActionLazy<CusInfo> mergeAddress = new ActionLazyCommom<CusInfo>(option, CusVisiMergeAddress.class);
		ActionLazy<CusInfo> mergePhone = new ActionLazyCommom<CusInfo>(option, CusVisiMergePhone.class);
		ActionLazy<CusInfo> nodeUser = new ActionLazyCommom<CusInfo>(option, CusVisiNodeUser.class);
		ActionLazy<CusInfo> mergeFimist = new ActionLazyCommom<CusInfo>(option, CusVisiMergeFimist.class);
		ActionLazy<CusInfo> mergePet = new ActionLazyCommom<CusInfo>(option, CusVisiMergePet.class);
		ActionLazy<CusInfo> mergeCutefilon = new ActionLazyCommom<CusInfo>(option, CusVisiMergeCutefilon.class);
		
		select.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(nodeUser);
		nodeUser.addPostAction(mergeFimist);
		mergeFimist.addPostAction(mergePet);
		mergePet.addPostAction(mergeCutefilon);
		
		actions.add(select);
		return actions;
	}
}
