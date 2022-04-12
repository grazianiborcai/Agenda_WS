package br.com.mind5.business.storeLeaveDateRange.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.action.StolargVisiMergeToSelect;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckLangu;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckOwner;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckRead;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class StolargRootSelect extends DeciTreeTemplateRead<StolargInfo> {
	
	public StolargRootSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolargInfo> buildCheckerHook(DeciTreeOption<StolargInfo> option) {
		List<ModelChecker<StolargInfo>> queue = new ArrayList<>();		
		ModelChecker<StolargInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolargCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolargCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolargInfo>> buildActionsOnPassedHook(DeciTreeOption<StolargInfo> option) {
		List<ActionStd<StolargInfo>> actions = new ArrayList<>();
		
		ActionStd<StolargInfo> select = new ActionStdCommom<StolargInfo>(option, StolargVisiMergeToSelect.class);
		
		actions.add(select);
		return actions;
	}
}
