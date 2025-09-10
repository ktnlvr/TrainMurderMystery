package dev.doctor4t.trainmurdermystery.datagen;

import dev.doctor4t.trainmurdermystery.block.OrnamentBlock;
import dev.doctor4t.trainmurdermystery.block.PanelBlock;
import dev.doctor4t.trainmurdermystery.block.property.OrnamentShape;
import dev.doctor4t.trainmurdermystery.index.TrainMurderMysteryBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.enums.BedPart;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Direction;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class TrainMurderMysteryBlockLootTableGen extends FabricBlockLootTableProvider {

    public TrainMurderMysteryBlockLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Vents
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_VENT_SHAFT);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_VENT_HATCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.DARK_STEEL_VENT_SHAFT);
        this.addSelfDrop(TrainMurderMysteryBlocks.DARK_STEEL_VENT_HATCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.TARNISHED_GOLD_VENT_SHAFT);
        this.addSelfDrop(TrainMurderMysteryBlocks.TARNISHED_GOLD_VENT_HATCH);
        // Metallic Blocks
        this.addFamily(TrainMurderMysteryBlocks.Family.TARNISHED_GOLD);
        this.addSelfDrop(TrainMurderMysteryBlocks.TARNISHED_GOLD_PILLAR);
        this.addFamily(TrainMurderMysteryBlocks.Family.GOLD);
        this.addSelfDrop(TrainMurderMysteryBlocks.GOLD_PILLAR);
        this.addFamily(TrainMurderMysteryBlocks.Family.PRISTINE_GOLD);
        this.addSelfDrop(TrainMurderMysteryBlocks.PRISTINE_GOLD_PILLAR);
        this.addFamily(TrainMurderMysteryBlocks.Family.WHITE_HULL);
        this.addSelfDrop(TrainMurderMysteryBlocks.CULLING_WHITE_HULL);
        this.addFamily(TrainMurderMysteryBlocks.Family.BLACK_HULL);
        this.addSelfDrop(TrainMurderMysteryBlocks.CULLING_BLACK_HULL);
        this.addFamily(TrainMurderMysteryBlocks.Family.BLACK_HULL_SHEET);
        this.addSelfDrop(TrainMurderMysteryBlocks.METAL_SHEET);
        this.addSelfDrop(TrainMurderMysteryBlocks.METAL_SHEET_STAIRS);
        this.addSelfDrop(TrainMurderMysteryBlocks.METAL_SHEET_SLAB);
        this.addSelfDrop(TrainMurderMysteryBlocks.METAL_SHEET_WALL);
        this.addSelfDrop(TrainMurderMysteryBlocks.METAL_SHEET_DOOR, this::doorDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.METAL_SHEET_WALKWAY);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_LADDER);
        this.addFamily(TrainMurderMysteryBlocks.Family.STAINLESS_STEEL);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_WALKWAY);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_PILLAR);
        // Glass
        this.addSelfDrop(TrainMurderMysteryBlocks.GOLDEN_GLASS_PANEL);
        this.addSelfDrop(TrainMurderMysteryBlocks.CULLING_GLASS);
        this.addSelfDrop(TrainMurderMysteryBlocks.RHOMBUS_GLASS);
        this.addSelfDrop(TrainMurderMysteryBlocks.HULL_GLASS);
        this.addSelfDrop(TrainMurderMysteryBlocks.PRIVACY_GLASS_PANEL);
        // Stones
        this.addFamily(TrainMurderMysteryBlocks.Family.MARBLE);
        this.addSelfDrop(TrainMurderMysteryBlocks.MARBLE_MOSAIC);
        this.addFamily(TrainMurderMysteryBlocks.Family.MARBLE_TILE);
        this.addFamily(TrainMurderMysteryBlocks.Family.DARK_MARBLE);
        // Woods
        this.addFamily(TrainMurderMysteryBlocks.Family.MAHOGANY);
        this.addFamily(TrainMurderMysteryBlocks.Family.MAHOGANY_HERRINGBONE);
        this.addFamily(TrainMurderMysteryBlocks.Family.SMOOTH_MAHOGANY);
        this.addSelfDrop(TrainMurderMysteryBlocks.MAHOGANY_PANEL, this::panelDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.MAHOGANY_CABINET, this::nameableContainerDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.MAHOGANY_BOOKSHELF);
        this.addFamily(TrainMurderMysteryBlocks.Family.BUBINGA);
        this.addFamily(TrainMurderMysteryBlocks.Family.BUBINGA_HERRINGBONE);
        this.addFamily(TrainMurderMysteryBlocks.Family.SMOOTH_BUBINGA);
        this.addSelfDrop(TrainMurderMysteryBlocks.BUBINGA_PANEL, this::panelDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.BUBINGA_CABINET, this::nameableContainerDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.BUBINGA_BOOKSHELF);
        this.addFamily(TrainMurderMysteryBlocks.Family.EBONY);
        this.addFamily(TrainMurderMysteryBlocks.Family.EBONY_HERRINGBONE);
        this.addFamily(TrainMurderMysteryBlocks.Family.SMOOTH_EBONY);
        this.addSelfDrop(TrainMurderMysteryBlocks.EBONY_PANEL, this::panelDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.EBONY_CABINET, this::nameableContainerDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.TRIMMED_EBONY_STAIRS);
        this.addSelfDrop(TrainMurderMysteryBlocks.EBONY_BOOKSHELF);
        this.addSelfDrop(TrainMurderMysteryBlocks.OAK_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.SPRUCE_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.BIRCH_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.JUNGLE_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.ACACIA_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.DARK_OAK_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.MANGROVE_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.CHERRY_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.BAMBOO_POLE);
        this.addSelfDrop(TrainMurderMysteryBlocks.CRIMSON_STIPE);
        this.addSelfDrop(TrainMurderMysteryBlocks.WARPED_STIPE);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_OAK_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_SPRUCE_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_BIRCH_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_JUNGLE_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_ACACIA_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_DARK_OAK_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_MANGROVE_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_CHERRY_BRANCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_BAMBOO_POLE);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_CRIMSON_STIPE);
        this.addSelfDrop(TrainMurderMysteryBlocks.STRIPPED_WARPED_STIPE);
        this.addSelfDrop(TrainMurderMysteryBlocks.PANEL_STRIPES);
        this.addSelfDrop(TrainMurderMysteryBlocks.TRIMMED_RAILING_POST, block -> this.drops(TrainMurderMysteryBlocks.TRIMMED_RAILING));
        this.addSelfDrop(TrainMurderMysteryBlocks.DIAGONAL_TRIMMED_RAILING, block -> this.drops(TrainMurderMysteryBlocks.TRIMMED_RAILING));
        this.addSelfDrop(TrainMurderMysteryBlocks.TRIMMED_RAILING);
        // Furniture / Decor
        this.addSelfDrop(TrainMurderMysteryBlocks.CARGO_BOX, this::nameableContainerDrops);
        this.addSelfDrop(TrainMurderMysteryBlocks.WHITE_LOUNGE_COUCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.WHITE_OTTOMAN);
        this.addSelfDrop(TrainMurderMysteryBlocks.WHITE_TRIMMED_BED, block -> this.dropsWithProperty(block, BedBlock.PART, BedPart.HEAD));
        this.addSelfDrop(TrainMurderMysteryBlocks.RED_TRIMMED_BED, block -> this.dropsWithProperty(block, BedBlock.PART, BedPart.HEAD));
        this.addSelfDrop(TrainMurderMysteryBlocks.BLUE_LOUNGE_COUCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.GREEN_LOUNGE_COUCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.RED_LEATHER_COUCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.BROWN_LEATHER_COUCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.BEIGE_LEATHER_COUCH);
        this.addSelfDrop(TrainMurderMysteryBlocks.COFFEE_TABLE);
        this.addSelfDrop(TrainMurderMysteryBlocks.BAR_TABLE);
        this.addSelfDrop(TrainMurderMysteryBlocks.BAR_STOOL);
        this.addSelfDrop(TrainMurderMysteryBlocks.GOLD_BAR);
        this.addSelfDrop(TrainMurderMysteryBlocks.GOLD_LEDGE);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_BAR);
        this.addSelfDrop(TrainMurderMysteryBlocks.TRIMMED_LANTERN);
        this.addSelfDrop(TrainMurderMysteryBlocks.WALL_LAMP);
        this.addSelfDrop(TrainMurderMysteryBlocks.NEON_PILLAR);
        this.addSelfDrop(TrainMurderMysteryBlocks.NEON_TUBE);
        this.addSelfDrop(TrainMurderMysteryBlocks.STAINLESS_STEEL_SPRINKLER);
        this.addSelfDrop(TrainMurderMysteryBlocks.GOLD_SPRINKLER);
        this.addSelfDrop(TrainMurderMysteryBlocks.SMALL_BUTTON);
        this.addSelfDrop(TrainMurderMysteryBlocks.ELEVATOR_BUTTON);
        this.addSelfDrop(TrainMurderMysteryBlocks.GOLD_ORNAMENT, this::ornamentDrops);
        this.addNothingDrop(TrainMurderMysteryBlocks.SMALL_GLASS_DOOR);
        this.addNothingDrop(TrainMurderMysteryBlocks.SMALL_WOOD_DOOR);
    }

    private void addFamily(BlockFamily family) {
        this.addFamily(family, this::addSelfDrop);
    }

    private void addFamily(BlockFamily family, Consumer<Block> consumer) {
        family.getVariants().values().forEach(consumer);
        consumer.accept(family.getBaseBlock());
    }

    private void addSelfDrop(Block block) {
        this.addSelfDrop(block, this::drops);
    }

    private void addSelfDrop(Block block, Function<Block, LootTable.Builder> function) {
        if (block.getHardness() == -1.0f) {
            // Register drops as nothing if block is unbreakable
            this.addDrop(block, dropsNothing());
        } else {
            this.addDrop(block, function);
        }
    }

    private void addNothingDrop(Block block) {
        this.addDrop(block, dropsNothing());
    }

    private ConstantLootNumberProvider count(float value) {
        return ConstantLootNumberProvider.create(value);
    }

    private LootTable.Builder panelDrops(Block block) {
        return LootTable.builder().pool(LootPool.builder().with(
                this.addSurvivesExplosionCondition(block, ItemEntry.builder(block))
                        .apply(
                                Direction.values(),
                                direction -> SetCountLootFunction.builder(this.count(1), true)
                                        .conditionally(BlockStatePropertyLootCondition.builder(block).properties(
                                                StatePredicate.Builder.create().exactMatch(PanelBlock.getProperty(direction), true)
                                        ))
                        ).apply(SetCountLootFunction.builder(this.count(-1f), true))
        ));
    }

    private LootTable.Builder ornamentDrops(Block block) {
        return LootTable.builder().pool(LootPool.builder().with(
                this.addSurvivesExplosionCondition(block, ItemEntry.builder(block))
                        .apply(
                                OrnamentShape.values(),
                                shape -> SetCountLootFunction.builder(this.count(shape.getCount()), false)
                                        .conditionally(BlockStatePropertyLootCondition.builder(block).properties(
                                                StatePredicate.Builder.create().exactMatch(OrnamentBlock.SHAPE, shape)
                                        ))
                        )
        ));
    }
}
