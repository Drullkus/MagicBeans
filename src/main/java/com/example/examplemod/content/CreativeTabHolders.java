package com.example.examplemod.content;

import com.example.examplemod.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tamaized.beanification.Autowired;

import java.util.Objects;

@tamaized.beanification.Component
public class CreativeTabHolders {
	@Autowired
	private BlockHolders blocks;

	@Autowired
	private ItemHolders items;

	public final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MODID);

	public final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("itemGroup.examplemod")) //The language key for the title of your CreativeModeTab
			.withTabsBefore(CreativeModeTabs.COMBAT)
			.icon(() -> items.EXAMPLE_ITEM.get().getDefaultInstance())
			.displayItems((parameters, output) -> {
				output.accept(blocks.EXAMPLE_BLOCK_ITEM.get());
				output.accept(items.EXAMPLE_ITEM.get());
			}).build());

	{
		IEventBus modBus = Objects.requireNonNull(ModLoadingContext.get().getActiveContainer().getEventBus());

		CREATIVE_MODE_TABS.register(modBus);
	}
}
