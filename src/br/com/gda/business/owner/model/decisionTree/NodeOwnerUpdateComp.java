package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceCompKey;
import br.com.gda.business.owner.model.action.LazyOwnerUpdateComp;
import br.com.gda.business.owner.model.action.StdOwnerEnforceEntityCateg;
import br.com.gda.business.owner.model.checker.OwnerCheckHasComp;
import br.com.gda.business.owner.model.checker.OwnerCheckUpdateComp;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerUpdateComp extends DeciTreeWriteTemplate<OwnerInfo> {

	public NodeOwnerUpdateComp(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		final boolean HAS_COMPANY = true;
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
			
		checker = new OwnerCheckUpdateComp();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_COMPANY;		
		checker = new OwnerCheckHasComp(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceEntityCateg = new StdOwnerEnforceEntityCateg(option);
		ActionLazy<OwnerInfo> enforceCompKey = new LazyOwnerEnforceCompKey(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> updateCompany = new LazyOwnerUpdateComp(option.conn, option.schemaName);
		
		enforceEntityCateg.addPostAction(enforceCompKey);
		enforceCompKey.addPostAction(updateCompany);
		
		actions.add(enforceEntityCateg);
		return actions;
	}
}
