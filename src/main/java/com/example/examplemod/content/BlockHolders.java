package com.example.examplemod.content;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import tamaized.beanification.Component;

import java.util.Objects;

@Component
public class BlockHolders {
	public final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ExampleMod.MODID);
	public final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MODID);

	public final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

	public final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

	{
		IEventBus modBus = Objects.requireNonNull(ModLoadingContext.get().getActiveContainer().getEventBus());

		BLOCKS.register(modBus);
		ITEMS.register(modBus);
	}
}
