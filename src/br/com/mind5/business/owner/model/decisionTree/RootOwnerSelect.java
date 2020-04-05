package br.com.mind5.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.action.LazyOwnerMergeAddress;
import br.com.mind5.business.owner.model.action.LazyOwnerMergeComp;
import br.com.mind5.business.owner.model.action.LazyOwnerMergeFimist;
import br.com.mind5.business.owner.model.action.LazyOwnerMergePerson;
import br.com.mind5.business.owner.model.action.LazyOwnerMergePhone;
import br.com.mind5.business.owner.model.action.LazyOwnerMergeUser;
import br.com.mind5.business.owner.model.action.StdOwnerMergeToSelect;
import br.com.mind5.business.owner.model.checker.OwnerCheckLangu;
import br.com.mind5.business.owner.model.checker.OwnerCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootOwnerSelect extends DeciTreeReadTemplate<OwnerInfo> {

	public RootOwnerSelect(DeciTreeOption<OwnerInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStdV1<OwnerInfo>> actions = new ArrayList<>();

		ActionStdV1<OwnerInfo> select = new StdOwnerMergeToSelect(option);
		ActionLazyV1<OwnerInfo> mergePerson = new LazyOwnerMergePerson(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> mergeComp = new LazyOwnerMergeComp(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> mergeAddress = new LazyOwnerMergeAddress(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> mergePhone = new LazyOwnerMergePhone(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> mergeUser = new LazyOwnerMergeUser(option.conn, option.schemaName);
		ActionLazyV1<OwnerInfo> mergeFimist = new LazyOwnerMergeFimist(option.conn, option.schemaName);
		
		select.addPostAction(mergePerson);
		mergePerson.addPostAction(mergeComp);
		mergeComp.addPostAction(mergeAddress);
		mergeAddress.addPostAction(mergePhone);
		mergePhone.addPostAction(mergeUser);
		mergeUser.addPostAction(mergeFimist);
		
		actions.add(select);
		return actions;
	}
}
	