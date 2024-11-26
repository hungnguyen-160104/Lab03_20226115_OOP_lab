public void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
  DigitalVideoDisc temp = new DigitalVideoDisc(
      dvd1.getTitle(), 
      dvd1.getCategory(), 
      dvd1.getDirector(), 
      dvd1.getLength(), 
      dvd1.getCost()
  );

  dvd1.setTitle(dvd2.getTitle());
  dvd1.setCategory(dvd2.getCategory());
  dvd1.setDirector(dvd2.getDirector());
  dvd1.setLength(dvd2.getLength());
  dvd1.setCost(dvd2.getCost());

  dvd2.setTitle(temp.getTitle());
  dvd2.setCategory(temp.getCategory());
  dvd2.setDirector(temp.getDirector());
  dvd2.setLength(temp.getLength());
  dvd2.setCost(temp.getCost());
}
