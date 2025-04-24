export interface PostCard {
  id: number;
  user: {
    alias: string;
    profilPictureUrl?: string;
  }
  mediaUrl: string;
  description: string;
  createdAt: number;
}
