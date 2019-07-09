package br.com.gda.payment.permissionResponseMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.model.action.LazyPeresmoipNodeCode;
import br.com.gda.payment.permissionResponseMoip.model.action.StdPeresmoipMergeToSelect;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckCode;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckExist;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckLangu;
import br.com.gda.payment.permissionResponseMoip.model.checker.PeresmoipCheckOwner;

public final class RootPeresmoipCode extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public RootPeresmoipCode(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new PeresmoipCheckCode();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new PeresmoipCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> mergeToSelect = new StdPeresmoipMergeToSelect(option);	
		ActionLazy<PeresmoipInfo> nodeCode = new LazyPeresmoipNodeCode(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(nodeCode);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
