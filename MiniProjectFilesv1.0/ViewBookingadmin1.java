        JButton bb4 = new JButton("VIEW BOOKINGS");
		bb4.setBounds(100,400,500,40);
                c.add(bb4);
		bb4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event)
		{
			new ViewBookings();
		}
		});
		
		bb4.setFont(f2);