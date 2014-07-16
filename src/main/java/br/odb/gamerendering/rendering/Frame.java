package br.odb.gamerendering.rendering;

public class Frame {
	private Sound sound;
	private RasterImage bitmap;

	public Frame(RasterImage bitmap2) {
		sound = null;
		bitmap = bitmap2;
	}

	/**
	 * @param sound
	 *            the sound to set
	 */
	public void setSound(Sound sound) {
		this.sound = sound;
	}

	/**
	 * @return the sound
	 */
	public Sound getSound() {
		return sound;
	}

	/**
	 * @param bitmap
	 *            the bitmap to set
	 */
	public void setBitmap(RasterImage bitmap) {
		this.bitmap = bitmap;
	}

	/**
	 * @return the bitmap
	 */
	public RasterImage getBitmap() {
		return bitmap;
	}

}
