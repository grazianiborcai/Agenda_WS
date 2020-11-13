package br.com.mind5.business.scheduleDayData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleDayData.model.action.StdSchedaytaMergeToSelect;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckLangu;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckOwner;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckRead;
import br.com.mind5.business.scheduleDayData.model.checker.SchedaytaCheckStore;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedaytaSelect extends DeciTreeTemplateWrite<SchedaytaInfo> {
	
	public RootSchedaytaSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedaytaInfo> buildCheckerHook(DeciTreeOption<SchedaytaInfo> option) {
		List<ModelChecker<SchedaytaInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedaytaInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedaytaCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedaytaCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedaytaCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedaytaCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedaytaInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedaytaInfo> option) {
		List<ActionStd<SchedaytaInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedaytaInfo> select = new StdSchedaytaMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
