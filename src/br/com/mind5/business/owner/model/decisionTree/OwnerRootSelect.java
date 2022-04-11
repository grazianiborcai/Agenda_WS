package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeAddress;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeBusarea;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeComp;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeFimist;
import br.com.mind5.business.owner.model.action.OwnerVisiMergePerson;
import br.com.mind5.business.owner.model.action.OwnerVisiMergePhone;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeToSelect;
import br.com.mind5.business.owner.model.action.OwnerVisiMergeUser;
import br.com.mind5.business.owner.model.checker.OwnerCheckLangu;
import br.com.mind5.business.owner.model.checker.OwnerCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OwnerRootSelect extends DeciTreeTemplateRead<OwnerInfo> {

	public OwnerRootSelect(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildCheckerHook(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnerCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();

		ActionStd<OwnerInfo> select = new ActionStdCommom<OwnerInfo>(option, OwnerVisiMergeToSelect.class);
		ActionLazy<OwnerInfo> mergeBusarea = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeBusarea.class);
		ActionLazy<OwnerInfo> mergePerson = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergePerson.class);
		ActionLazy<OwnerInfo> mergeComp = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeComp.class);
		ActionLazy<OwnerInfo> mergeAddress = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeAddress.class);
		ActionLazy<OwnerInfo> mergePhone = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergePhone.class);
		ActionLazy<OwnerInfo> mergeUser = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeUser.class);
		ActionLazy<OwnerInfo> mergeFimist = new ActionLazyCommom<OwnerInfo>(option, OwnerVisiMergeFimist.class);		
		
		select.addPostAction(mergeBusarea);
		mergeBusarea.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeComp);
		mergeComp.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
	