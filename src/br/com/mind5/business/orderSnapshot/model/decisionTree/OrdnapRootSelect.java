package br.com.mind5.business.orderSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.action.OrdnapVisiMergeToSelect;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckLangu;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckOwner;
import br.com.mind5.business.orderSnapshot.model.checker.OrdnapCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OrdnapRootSelect extends DeciTreeTemplateRead<OrdnapInfo> {
	
	public OrdnapRootSelect(DeciTreeOption<OrdnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdnapInfo> buildCheckerHook(DeciTreeOption<OrdnapInfo> option) {
		List<ModelChecker<OrdnapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OrdnapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdnapCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new OrdnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdnapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdnapInfo> option) {
		List<ActionStd<OrdnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<OrdnapInfo> select = new ActionStdCommom<OrdnapInfo>(option, OrdnapVisiMergeToSelect.class);
		
		actions.add(select);			
		return actions;
	}
}
