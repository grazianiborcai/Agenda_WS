package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckOwner;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckRead;

public final class RootOwnparSelect extends DeciTreeTemplateRead<OwnparInfo> {
	
	public RootOwnparSelect(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnparInfo> buildCheckerHook(DeciTreeOption<OwnparInfo> option) {
		List<ModelChecker<OwnparInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnparCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnparCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStd<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnparInfo> nodeSelect = new NodeOwnparSelect(option).toAction();
		
		actions.add(nodeSelect);
		return actions;
	}
}
