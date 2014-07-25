package br.odb.gamerendering.rendering;

import br.odb.utils.Rect;
import br.odb.utils.math.Vec2;

public class Tile extends RenderingNode implements Constants {
	private int kind;
	private int myColor;
	private boolean block;
	private RasterImage tileImage;

	/**
	 * @return the block
	 */
	public boolean isBlock() {
		return block;
	}

	public RasterImage getBitmap() {
		return tileImage;
	}

	public void setImage(RasterImage bitmap) {
		this.tileImage = bitmap;
	}

	/**
	 * @param block
	 *            the block to set
	 */
	public void setBlock(boolean block) {
		this.block = block;
	}

	/**
	 * @return the kind
	 */
	public int getKind() {
		return kind;
	}

	/**
	 * @param kind
	 *            the kind to set
	 */
	public void setKind(int kind) {
		this.kind = kind;
		block = (kind != 0) && (kind != 3);
	}

	/**
	 * @return the myColor
	 */
	public int getMyColor() {
		return myColor;
	}

	/**
	 * @param myColor
	 *            the myColor to set
	 */
	public void setMyColor(int myColor) {
		this.myColor = myColor;
	}

	public Tile(int x, int y, int kind) {
            
                super( "tile_" + x + "_" + y );
                
		if (kind < 0)
			kind = 0;

		visible = true;

		setKind(kind);
		bounds.p0.set(x * TILE_SIZE_X, y * TILE_SIZE_Y);
	}

	public Tile(Rect rect, RasterImage rasterImage) {
            
                super( "tile_" + rect.p0.x + "_" + rect.p0.y );
		visible = true;
		kind = 0;
		bounds.set(rect);
		setImage(rasterImage);
	}

	public Tile(RasterImage image) {
                super( "tile_0_0" );
		visible = true;
		kind = 0;
		Rect rect = new Rect();
		rect.p0.x = 0;
		rect.p0.y = 0;
		rect.p1.x = image.getWidth();
		rect.p1.y = image.getHeight();
		bounds.set(rect);
		setImage(image);
	}

	@Override
	public void render(RenderingContext currentRenderingContext) {

		currentRenderingContext.drawBitmap(tileImage, bounds);
	}
}
