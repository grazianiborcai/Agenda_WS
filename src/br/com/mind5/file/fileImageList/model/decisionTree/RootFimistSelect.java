package br.com.mind5.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.action.StdFimistMergeToSelect;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckLangu;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckOwner;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootFimistSelect extends DeciTreeTemplateReadV2<FimistInfo> {
	
	public RootFimistSelect(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FimistInfo> buildCheckerHook(DeciTreeOption<FimistInfo> option) {
		List<ModelCheckerV1<FimistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FimistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FimistCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimistCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FimistCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStdV2<FimistInfo>> actions = new ArrayList<>();
		
		ActionStdV2<FimistInfo> select = new StdFimistMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
