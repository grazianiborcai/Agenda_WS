package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerKeepOwner;
import br.com.gda.business.owner.model.action.LazyOwnerMergeUsername;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpdateComp;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpdatePerson;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertAddress;
import br.com.gda.business.owner.model.action.LazyOwnerNodeUpsertPhone;
import br.com.gda.business.owner.model.action.LazyOwnerUpdate;
import br.com.gda.business.owner.model.action.StdOwnerEnforceLChanged;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
import br.com.gda.business.owner.model.checker.OwnerCheckUpdate;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootOwnerUpdate implements DeciTree<OwnerInfo> {
	private DeciTree<OwnerInfo> tree;
	
	
	public RootOwnerUpdate(DeciTreeOption<OwnerInfo> option) {
		DeciTreeHelperOption<OwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwnerInfo> buildDecisionChecker(DeciTreeOption<OwnerInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new OwnerCheckUpdate();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwnerCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<OwnerInfo>> buildActionsOnPassed(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();

		ActionStd<OwnerInfo> enforceLChanged = new StdOwnerEnforceLChanged(option);
		ActionLazy<OwnerInfo> mergeLChangedBy = new LazyOwnerMergeUsername(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> keepOwner = new LazyOwnerKeepOwner(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> updateOwner = new LazyOwnerUpdate(option.conn, option.schemaName);	
		ActionLazy<OwnerInfo> updatePerson = new LazyOwnerNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> updateCompany = new LazyOwnerNodeUpdateComp(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertAddress = new LazyOwnerNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> upsertPhone = new LazyOwnerNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<OwnerInfo> select = new RootOwnerSelect(option).toAction();		
		
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(keepOwner);
		
		keepOwner.addPostAction(updateOwner);		
		keepOwner.addPostAction(updatePerson);
		keepOwner.addPostAction(updateCompany);		
		keepOwner.addPostAction(upsertAddress);		
		keepOwner.addPostAction(upsertPhone);
		
		actions.add(enforceLChanged);
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<OwnerInfo> toAction() {
		return tree.toAction();
	}
}
